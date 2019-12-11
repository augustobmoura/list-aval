package br.ufg.inf.es.listaval.utils;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.function.Function;

public final class Result<T, E> {

	private final T successValue;
	private final E errorValue;

	private Result(final T successValue, final E errorValue) {
		this.successValue = successValue;
		this.errorValue = errorValue;
	}

	public static <A, B> Result<A, B> ofSuccess(@NotNull final A value) {
		return new Result<>(value, null);
	}

	public static <A, B> Result<A, B> ofError(@NotNull final B value) {
		return new Result<>(null, value);
	}

	public Optional<T> success() {
		return Optional.ofNullable(successValue);
	}

	public Optional<E> error() {
		return Optional.ofNullable(errorValue);
	}

	public <R> R map(final Function<T, R> successMapper, Function<E, R> errorMapper) {
		return success().map(successMapper)
			.orElseGet(() -> error().map(errorMapper).get());
	}

}
