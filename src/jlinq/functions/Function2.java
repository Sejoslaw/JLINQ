package jlinq.functions;

/**
 * 
 * @author Krzysztof Dobrzynski - k.dobrzynski94@gmail.com
 *
 * @param <TInput1> First input.
 * @param <TInput2> Second input.
 * @param <TResult> Result.
 */
public interface Function2<TInput1, TInput2, TResult> {
	public TResult apply(TInput1 input1, TInput2 input2);
}
