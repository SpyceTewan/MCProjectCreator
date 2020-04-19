package at.tewan.mcpc.resource;

public class Resource {

	private String namespace;
	private String identifier;

	public Resource(String namespace, String identifier) {
		this.namespace = namespace;
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
}
