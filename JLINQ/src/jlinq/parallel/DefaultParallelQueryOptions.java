package jlinq.parallel;

/**
 * 
 * Default implementation of {@link IParallelQueryOptions}.
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 */
public class DefaultParallelQueryOptions implements IParallelQueryOptions {

	/**
	 * Represents the number of threads used by parallel query.
	 */
	private int _numberOfThreads;

	public DefaultParallelQueryOptions(int numberOfThreads) {
		this._numberOfThreads = numberOfThreads;
	}

	public int getNumberOfThreads() {
		return this._numberOfThreads;
	}
}
