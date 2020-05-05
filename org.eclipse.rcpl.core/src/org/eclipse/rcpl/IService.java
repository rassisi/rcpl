package org.eclipse.rcpl;

import org.eclipse.rcpl.model_2_0_0.rcpl.Command;

/**
 * @author ramin
 *
 */
public interface IService {

	Object execute(ICommand command);

	void selectGroup(String id, int shelfIndex, boolean b);

	void registerService(EnServiceId serviceId, IService service);

	void registerService(Class<? extends IService> serviceClass);

	@Deprecated
	Object doExecute(ICommand command) throws Exception;

	Object doExecute(Command command) throws Exception;

}
