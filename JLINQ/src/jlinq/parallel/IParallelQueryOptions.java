package jlinq.parallel;

/**
 * 
 * Contains various options passed to parallel JLinq query. For default
 * implementation see: {@link DefaultParallelQueryOptions}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public interface IParallelQueryOptions {

	/**
	 * @return Returns the number of threads used by parallel query. If the number
	 *         of the elements passed to query is odd it will be +1.
	 */
	public int getNumberOfThreads();
}
