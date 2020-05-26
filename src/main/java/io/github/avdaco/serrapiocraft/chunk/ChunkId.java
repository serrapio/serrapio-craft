package io.github.avdaco.serrapiocraft.chunk;

public class ChunkId {

	private int x;
	private int z;
	
	public ChunkId(int x, int z) {
		super();
		this.x = x;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + z;
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
		ChunkId other = (ChunkId) obj;
		if (x != other.x)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	
}
