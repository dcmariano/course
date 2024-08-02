package genericssetmap.entities;

import java.time.OffsetDateTime;
import java.util.Objects;

public class LogAcess {
	private String name;
	private OffsetDateTime moment;

	public LogAcess() {

	}

	public LogAcess(String name, OffsetDateTime moment) {
		this.name = name;
		this.moment = moment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OffsetDateTime getMoment() {
		return moment;
	}

	public void setMoment(OffsetDateTime moment) {
		this.moment = moment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogAcess other = (LogAcess) obj;
		return Objects.equals(name, other.name);
	}
}
