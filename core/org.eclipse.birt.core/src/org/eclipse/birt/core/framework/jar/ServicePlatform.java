/*******************************************************************************
 * Copyright (c) 2010 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.core.framework.jar;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.birt.core.framework.IBundle;
import org.eclipse.birt.core.framework.IConfigurationElement;
import org.eclipse.birt.core.framework.IExtension;
import org.eclipse.birt.core.framework.IExtensionRegistry;
import org.eclipse.birt.core.framework.IPlatform;
import org.eclipse.birt.core.framework.IPlatformPath;
import org.eclipse.birt.core.framework.eclipse.EclipseExtensionRegistry;
import org.eclipse.core.internal.runtime.AdapterManager;
import org.eclipse.core.runtime.IAdapterManager;
import org.eclipse.core.runtime.Platform;
import org.xml.sax.SAXException;

public class ServicePlatform implements IPlatform
{

	protected static Logger logger = Logger.getLogger( IPlatform.class
			.getName( ) );

	HashMap<String, Bundle> bundles = new HashMap<String, Bundle>( );
	ExtensionRegistry extensionRegistry = new ExtensionRegistry( );

	ServicePlatform( )
	{

	}

	public void installBundle( URL root ) throws IOException,
			ParserConfigurationException, SAXException
	{
		Bundle bundle = new BundleLoader( this, root ).load( );
		if ( bundle != null )
		{
			bundles.put( bundle.getSymbolicName( ), bundle );
			extensionRegistry.addBundle( bundle );
		}
	}

	public IBundle getBundle( String symbolicName )
	{
		return bundles.get( symbolicName );
	}

	public IExtensionRegistry getExtensionRegistry( )
	{
		return new EclipseExtensionRegistry( Platform.getExtensionRegistry( ) );
	}

	public IAdapterManager getAdapterManager( )
	{
		return AdapterManager.getDefault( );
	}

	public URL asLocalURL( URL url ) throws IOException
	{
		return url;
	}

	public String getDebugOption( String name )
	{
		return null;
	}

	public void initializeTracing( String pluginName )
	{
	}

	public Object createFactoryObject( String extensionId )
	{
		try
		{
			IExtensionRegistry registry = getExtensionRegistry( );
			String extensionPointId = "org.eclipse.birt.core."
					+ IPlatform.EXTENSION_POINT_FACTORY_SERVICE;
			IExtension factoryExt = registry.getExtension( extensionPointId,
					extensionId );
			if ( factoryExt != null )
			{
				IConfigurationElement[] configs = factoryExt
						.getConfigurationElements( );
				if ( configs != null && configs.length > 0 )
				{
					IConfigurationElement config = configs[0];
					Object factory = config.createExecutableExtension( "class" );
					return factory;
				}
			}
		}
		catch ( Exception ex )
		{
			logger.log( Level.WARNING, ex.getMessage( ), ex );
		}
		return null;
	}

	public Object enterPlatformContext( )
	{
		return null;
	}

	public void exitPlatformContext( Object context )
	{
	}

	// the os.name value list: http://lopica.sourceforge.net/os.html

	public String getOS( )
	{
		String os = System.getProperty( "os.name" );
		if ( os == null )
		{
			return OS_UNKNOWN;
		}
		if ( os.startsWith( "Windows" ) )
		{
			return OS_WIN32;
		}
		else if ( os.equals( "Linux" ) )
		{
			return OS_LINUX;
		}
		else if ( os.equals( "AIX" ) )
		{
			return OS_AIX;
		}
		else if ( os.equals( "SunOS" ) || os.equals( "Solaris" ) )
		{
			return OS_SOLARIS;
		}
		else if ( os.equals( "HP-UX" ) )
		{
			return OS_HPUX;
		}
		else if ( os.equals( "Mac OS" ) || os.equals( "Mac OS X" ) )
		{
			return OS_MACOSX;
		}
		return OS_UNKNOWN;
	}

	public URL find( String bundleId, String path )
	{
		Bundle bundle = (Bundle) getBundle( bundleId );
		if ( bundle != null )
		{
			try
			{
				return new URL( bundle.root, path );
			}
			catch ( MalformedURLException e )
			{
				return null;
			}
		}
		return null;
	}

	public URL toFileURL( URL url )
	{
		if ( "file".equals( url.getProtocol( ) ) )
		{
			return url;
		}
		return null;
	}

	public URL find( IBundle bundle, IPlatformPath path )
	{
		return null;
	}
}
