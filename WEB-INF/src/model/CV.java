package model;

public class CV {

	private int id;
	private String path;
	private Job job;
	
	public CV(){
		
	}
	
	public CV(String path, Job job) {
		super();
		this.path = path;
		this.job = job;
	}


	public CV(int id, String path, Job job) {
		super();
		this.id = id;
		this.path = path;
		this.job = job;
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

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((job == null) ? 0 : job.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
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
		CV other = (CV) obj;
		if (id != other.id)
			return false;
		if (job == null) {
			if (other.job != null)
				return false;
		} else if (!job.equals(other.job))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CV [id=" + id + ", path=" + path + ", job=" + job + "]";
	}
	
	
}
