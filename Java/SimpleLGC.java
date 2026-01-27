package Java;

public class SimpleLGC {
	// LCG (not encryption): x_{n+1} = (a*x_n + c) mod m
	private long x;
	private static final long A = 1664525L;
	private static final long C = 1013904223L;
	private static final long M = 1L << 32; // 2^32

	public SimpleLGC(long seed) {
		this.x = seed;
	}

	public int nextInt() {
		x = (A * x + C) % M;
		return (int) x;
	}

	public int nextInt(int bound) {
		if (bound <= 0)
			throw new IllegalArgumentException("bound must be > 0");
		return (nextInt() >>> 1) % bound;
	}

	public static void main(String[] args) {
		SimpleLGC rng = new SimpleLGC(System.nanoTime());
		for (int i = 0; i < 5; i++)
			System.out.println(rng.nextInt(100));
	}
}
