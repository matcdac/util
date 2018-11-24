package utilities.log.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import lombok.Data;

@Data
public class GenericException implements Serializable {

	private static final long serialVersionUID = 1;

	private List<KahaFata> kahaKahaPhataHeirarchy;

	private FataMeta fataMeta;

	public void addFatneKiHeirarchy(StackTraceElement stackTraceElement) {
		KahaFata kahaFata = new KahaFata(stackTraceElement);
		this.kahaKahaPhataHeirarchy.add(kahaFata);
	}

	public void setFatneKiHeirarchy(StackTraceElement[] stackTraceElements) {
		this.kahaKahaPhataHeirarchy = new ArrayList<KahaFata>();

		// Parallel
		IntStream.range(0, stackTraceElements.length).parallel()
				.forEach(i -> this.addFatneKiHeirarchy(stackTraceElements[i]));

		// Sequential
		/*
		 * for (StackTraceElement stackTraceElement : stackTraceElements) {
		 * this.addFatneKiHeirarchy(stackTraceElement); }
		 */
	}

	public void setFataMeta(String classType, String message, Throwable cause) {
		this.fataMeta = new FataMeta(classType, message, cause);
	}

	public GenericException() {

	}

	public GenericException(Exception e) {
		this.setFatneKiHeirarchy(e.getStackTrace());
		this.setFataMeta(e.getClass().getName(), e.getMessage(), e.getCause());
	}

}
