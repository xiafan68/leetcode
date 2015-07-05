package fanxia.graph;

import junit.framework.Assert;

public class NumIslands {
	public int numIslands(char[][] grid) {
		int ret = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					ret++;
					dfs(grid, i, j);
				}
				grid[i][j] = 'v';
			}
		}
		return ret;
	}

	/**
	 * 边界处理
	 * @param grid
	 * @param x
	 * @param y
	 */
	private void dfs(char[][] grid, int x, int y) {
		char pre = grid[x][y];
		grid[x][y] = 'v';
		if (pre == '1') {
			if (x - 1 >= 0)
				dfs(grid, x - 1, y);
			if (x + 1 < grid.length)
				dfs(grid, x + 1, y);
			if (y + 1 < grid[x].length)
				dfs(grid, x, y + 1);
			if (y - 1 >= 0)
				dfs(grid, x, y - 1);
		}
	}

	public static void main(String[] args) {
		NumIslands lands = new NumIslands();
		Assert.assertEquals(
				1,
				lands.numIslands(new char[][] { { '1', '1', '1', '1', '0' },
						{ '1', '1', '0', '1', '0' },
						{ '1', '1', '0', '0', '0' },
						{ '0', '0', '0', '0', '0' } }));
		Assert.assertEquals(
				1,
				lands.numIslands(new char[][] { { '1', '1', '1' },
						{ '0', '1', '0' }, { '1', '1', '1' } }));
		Assert.assertEquals(
				1,
				lands.numIslands(new char[][] { { '1', '0', '1', '1', '1' },
						{ '1', '0', '1', '0', '1' },
						{ '1', '1', '1', '0', '1' } }));

	}
}