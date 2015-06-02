package model;

public class FileProject {

	private int id;
	private String path;
	private Project proejct;
	
	public FileProject(){
		
	}
	
	public FileProject(String path, Project proejct) {
		super();
		this.path = path;
		this.proejct = proejct;
	}

	public FileProject(int id, String path, Project proejct) {
		super();
		this.id = id;
		this.path = path;
		this.proejct = proejct;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Project getProejct() {
		return proejct;
	}

	public void setProejct(Project proejct) {
		this.proejct = proejct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((proejct == null) ? 0 : proejct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileProject other = (FileProject) obj;
		if (id != other.id)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (proejct == null) {
			if (other.proejct != null)
				return false;
		} else if (!proejct.equals(other.proejct))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileProject [id=" + id + ", path=" + path + ", proejct="
				+ proejct + "]";
	}
	
	
}
