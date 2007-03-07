/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.report.item.crosstab.core;

import org.eclipse.birt.report.model.api.activity.SemanticException;
import org.eclipse.birt.report.model.core.DesignElement;

/**
 * Represents exceptions encountered during crosstab actions, it will include a
 * reference to the element which causes the error.
 * 
 */

public class CrosstabException extends SemanticException
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7908514127634678177L;
	/**
	 * The plugin id of all the crosstab exceptions.
	 */

	public static final String CROSSTAB_PLUGIN_ID = "org.eclipse.birt.report.item.crosstab.core"; //$NON-NLS-1$

	/**
	 * @param element
	 * @param errCode
	 * @param cause
	 */
	public CrosstabException( DesignElement element, String errCode,
			Throwable cause )
	{
		super( element, errCode, cause );
		this.pluginId = CROSSTAB_PLUGIN_ID;
	}

	/**
	 * @param element
	 * @param errCode
	 */
	public CrosstabException( DesignElement element, String errCode )
	{
		super( element, errCode );
		this.pluginId = CROSSTAB_PLUGIN_ID;
	}

	/**
	 * @param element
	 * @param values
	 * @param errCode
	 * @param cause
	 */
	public CrosstabException( DesignElement element, String[] values,
			String errCode, Throwable cause )
	{
		super( element, values, errCode, cause );
		this.pluginId = CROSSTAB_PLUGIN_ID;
	}

	/**
	 * @param element
	 * @param values
	 * @param errCode
	 */
	public CrosstabException( DesignElement element, String[] values,
			String errCode )
	{
		super( element, values, errCode );
		this.pluginId = CROSSTAB_PLUGIN_ID;
	}
}
