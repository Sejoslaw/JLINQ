package jlinq.parallel;

/**
 * 
 * Contains various options passed to parallel JLINQ query. For default
 * implementation see: {@link DefaultParallelQueryOptions}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public interface IParallelQueryOptions {

	/**
	 * @return Returns the number of threads used by parallel query.
	 */
	public int getNumberOfThreads();
}
