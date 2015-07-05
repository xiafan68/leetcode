package fanxia.list;

import java.util.HashMap;

public class LRUCache {
	HashMap<Integer, LRUListNode> cacheData = new HashMap<Integer, LRUListNode>();
	LRUListNode header = null;
	LRUListNode tail = null;
	private int limit;

	public LRUCache(int limit) {
		this.limit = limit;
	}

	private class LRUListNode {
		public LRUListNode pre = null;
		public LRUListNode next = null;
		public Integer key;
		public Integer value = null;

		public LRUListNode(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}
	}

	private void lruHit(LRUListNode node) {
		lruRemove(node);
		lruInsert(node);
	}

	private void lruInsert(LRUListNode node) {
		node.next = header;
		node.pre = null;

		if (header != null) {
			header.pre = node;
		}
		header = node;
		if (tail == null) {
			tail = node;
		}
	}

	private void lruRemove(LRUListNode node) {
		if (header == node) {
			header = node.next;
		}

		if (tail == node) {
			tail = node.pre;
		}

		if (node.pre != null) {
			node.pre.next = node.next;
		}
		if (node.next != null) {
			node.next.pre = node.pre;
		}
		node.pre = null;
		node.next = null;
	}

	public void set(Integer key, Integer value) {
		if (cacheData.containsKey(key)) {
			LRUListNode pre = cacheData.get(key);
			pre.value = value;
			lruHit(pre);
			return;
		}

		while (cacheData.size() >= limit) {
			if (tail != null) {
				cacheData.remove(tail.key);
				lruRemove(tail);
			} else
				break;
		}

		LRUListNode node = new LRUListNode(key, value);
		cacheData.put(key, node);
		lruInsert(node);
	}

	public int get(Integer key) {
		if (cacheData.containsKey(key)) {
			LRUListNode node = cacheData.get(key);
			lruHit(node);
			return node.value;
		}
		return -1;
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.set(4, 4);
		System.out.println(cache.get(4));
		System.out.println(cache.get(3));
		System.out.println(cache.get(2));
		System.out.println(cache.get(1));
		cache.set(5, 5);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
	}
}
