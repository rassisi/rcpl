package org.eclipse.rcpl;

/**
 * @author Ramin
 *
 */
public interface IServiceFactory {

	IService createService(EnServiceId id);

	IService createService(String id);

}
