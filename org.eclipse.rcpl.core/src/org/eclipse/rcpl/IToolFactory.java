package org.eclipse.rcpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.Tool;

/**
 * @author ramin
 *
 */
public interface IToolFactory {
	ITool createTool(final Tool tool, Object... data);
}
