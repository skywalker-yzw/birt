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

/**
 * ICrosstabConstants
 */
public interface ICrosstabConstants
{

	/**
	 * Extension name of crosstab.
	 */
	String CROSSTAB_EXTENSION_NAME = "Crosstab"; //$NON-NLS-1$

	/**
	 * Extension name of crosstab view.
	 */
	String CROSSTAB_VIEW_EXTENSION_NAME = "CrosstabView"; //$NON-NLS-1$

	/**
	 * Extension name of dimension view.
	 */
	String DIMENSION_VIEW_EXTENSION_NAME = "DimensionView"; //$NON-NLS-1$

	/**
	 * Extension name of level view.
	 */
	String LEVEL_VIEW_EXTENSION_NAME = "LevelView"; //$NON-NLS-1$

	/**
	 * Extension name of measure view.
	 */
	String MEASURE_VIEW_EXTENSION_NAME = "MeasureView"; //$NON-NLS-1$

	/**
	 * Extension name of crosstab cell.
	 */
	String CROSSTAB_CELL_EXTENSION_NAME = "CrosstabCell"; //$NON-NLS-1$

	/**
	 * Extension name of aggregation cell.
	 */
	String AGGREGATION_CELL_EXTENSION_NAME = "AggregationCell"; //$NON-NLS-1$

	/**
	 * Extension name of crosstab member value.
	 */
	String CROSSTAB_MEMBER_VALUE_EXTENSION_NAME = "CrosstabMemberValue"; //$NON-NLS-1$
	/**
	 * Extension name of header cell.
	 */
	// String HEADER_CELL_EXTENSION_NAME = "HeaderCell"; //$NON-NLS-1$
	
	/**
	 * Constants of row axis type.
	 */
	int ROW_AXIS_TYPE = 0;

	/**
	 * Constants of column axis type.
	 */
	int COLUMN_AXIS_TYPE = 1;
	
	/**
	 * Constants of not effective axis type.
	 */
	int NO_AXIS_TYPE = -1;

	/**
	 * Measure direction constants.
	 */
	String MEASURE_DIRECTION_HORIZONTAL = "horizontal"; //$NON-NLS-1$
	String MEASURE_DIRECTION_VERTICAL = "vertical"; //$NON-NLS-1$

	/**
	 * Page layout constants.
	 */
	String PAGE_LAYOUT_DOWN_THEN_OVER = "Down then over"; //$NON-NLS-1$
	String PAGE_LAYOUT_OVER_THEN_DOWN = "Over then down"; //$NON-NLS-1$

	/**
	 * Aggregation location constants.
	 */
	String AGGREGATION_HEADER_LOCATION_BEFORE = "Before"; //$NON-NLS-1$
	String AGGREGATION_HEADER_LOCATION_AFTER = "After"; //$NON-NLS-1$
}
