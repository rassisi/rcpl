package org.eclipse.rcpl;

/**
 * @author ramin
 *
 */
public interface IService {

	Object execute(ICommand command);

	void selectGroup(String id, int shelfIndex, boolean b);

	void registerService(EnServiceId serviceId, IService service);

	void registerService(Class<? extends IService> serviceClass);

	Object doExecute(ICommand command) throws Exception;

}
