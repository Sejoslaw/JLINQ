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
	private int numberOfThreads;

	public DefaultParallelQueryOptions(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public int getNumberOfThreads() {
		return this.numberOfThreads;
	}
}
