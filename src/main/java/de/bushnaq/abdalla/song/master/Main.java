package de.bushnaq.abdalla.song.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Main {
	@Autowired
	private Context		context;
//	private final Logger	logger	= LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SongMaster	main;

	/**
	 * bean
	 */
	public Main() {

	}

	public void start(String[] args) throws Exception {
		context.getParameterOptions().start(args);

		main.start();
	}

}
