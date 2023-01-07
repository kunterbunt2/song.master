package de.bushnaq.abdalla.song.master;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Context {
	private ParameterOptions ParameterOptions = new ParameterOptions();

	public ParameterOptions getParameterOptions() {
		return ParameterOptions;
	}
}
