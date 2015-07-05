package fanxia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * TODO:
 * @author xiafan
 *
 */
public class WordLadder {

	HashMap<String, Integer> state = new HashMap<String, Integer>();
	Queue<String> fQueue = new LinkedList<String>();
	Queue<String> bQueue = new LinkedList<String>();
	String start, end;
	private boolean startEnded;
	private boolean endEnded;

	public int ladderLength(String start, String end, Set<String> dict) {
		fQueue.clear();
		bQueue.clear();
		state.clear();

		startEnded = true;
		endEnded = true;
		this.start = start;
		this.end = end;
		fQueue.add(start);
		bQueue.add(end);

		for (String word : dict) {
			state.put(word, 0);
		}

		int ret = 0;
		while (!fQueue.isEmpty() || !bQueue.isEmpty()) {
			Queue<String> tmp = fQueue;
			fQueue = new LinkedList<String>();
			ret = traverse(tmp, fQueue, 1);
			if (ret > 0)
				break;
			tmp = bQueue;
			bQueue = new LinkedList<String>();
			ret = traverse(tmp, bQueue, -1);
			if (ret > 0)
				break;
		}
		return ret;
	}

	private int traverse(Queue<String> tQueue, Queue<String> newQueue, int step) {
		int ret = 0;
		for (String word : tQueue) {
			char[] chars = word.toCharArray();
			for (int i = 0; i < word.length(); i++) {
				char oldChar = chars[i];
				for (char rchar = 'a'; rchar <= 'z'; rchar++) {
					if (chars[i] == rchar)
						continue;
					chars[i] = rchar;
					String tmp = new String(chars);
					if (state.containsKey(tmp)) {
						int preStep = 0;
						if (state.containsKey(word))
							preStep = state.get(word);
						if (preStep * state.get(tmp) < 0) {
							ret = Math.abs(state.get(word))
									+ Math.abs(state.get(tmp)) + 1 + 1;
							break;
						} else if (state.get(tmp) == 0) {
							state.put(tmp, preStep + step);
							newQueue.add(tmp);
						}
					} else if (step > 0 && !startEnded && tmp.equals(end)) {
						ret = Math.abs(state.get(word)) + 2;
						break;
					} else if (step < 0 && !endEnded && tmp.equals(start)) {
						ret = Math.abs(state.get(word)) + 2;
						break;
					}
					chars[i] = oldChar;
				}
			}
		}
		if (step > 0)
			startEnded = false;
		else {
			endEnded = false;
		}
		return ret;
	}

	public static void main(String[] args) {
		String start = "hit";
		String end = "cog";
		Set dict = new HashSet();
		dict.addAll(Arrays.asList("hot", "dot", "dog", "lot", "log"));
		WordLadder ladder = new WordLadder();
		System.out.println(ladder.ladderLength(start, end, dict));

		start = "a";
		end = "c";
		dict = new HashSet();
		dict.addAll(Arrays.asList("a", "b", "c"));
		System.out.println(ladder.ladderLength(start, end, dict));

		start = "hot";
		end = "dog";
		dict = new HashSet();
		dict.addAll(Arrays.asList("hot", "dog", "dot"));
		System.out.println(ladder.ladderLength(start, end, dict));

		start = "cet";
		end = "ism";
		dict = new HashSet();
		dict.addAll(Arrays.asList("kid", "tag", "pup", "ail", "tun", "woo",
				"erg", "luz", "brr", "gay", "sip", "kay", "per", "val", "mes",
				"ohs", "now", "boa", "cet", "pal", "bar", "die", "war", "hay",
				"eco", "pub", "lob", "rue", "fry", "lit", "rex", "jan", "cot",
				"bid", "ali", "pay", "col", "gum", "ger", "row", "won", "dan",
				"rum", "fad", "tut", "sag", "yip", "sui", "ark", "has", "zip",
				"fez", "own", "ump", "dis", "ads", "max", "jaw", "out", "btu",
				"ana", "gap", "cry", "led", "abe", "box", "ore", "pig", "fie",
				"toy", "fat", "cal", "lie", "noh", "sew", "ono", "tam", "flu",
				"mgm", "ply", "awe", "pry", "tit", "tie", "yet", "too", "tax",
				"jim", "san", "pan", "map", "ski", "ova", "wed", "non", "wac",
				"nut", "why", "bye", "lye", "oct", "old", "fin", "feb", "chi",
				"sap", "owl", "log", "tod", "dot", "bow", "fob", "for", "joe",
				"ivy", "fan", "age", "fax", "hip", "jib", "mel", "hus", "sob",
				"ifs", "tab", "ara", "dab", "jag", "jar", "arm", "lot", "tom",
				"sax", "tex", "yum", "pei", "wen", "wry", "ire", "irk", "far",
				"mew", "wit", "doe", "gas", "rte", "ian", "pot", "ask", "wag",
				"hag", "amy", "nag", "ron", "soy", "gin", "don", "tug", "fay",
				"vic", "boo", "nam", "ave", "buy", "sop", "but", "orb", "fen",
				"paw", "his", "sub", "bob", "yea", "oft", "inn", "rod", "yam",
				"pew", "web", "hod", "hun", "gyp", "wei", "wis", "rob", "gad",
				"pie", "mon", "dog", "bib", "rub", "ere", "dig", "era", "cat",
				"fox", "bee", "mod", "day", "apr", "vie", "nev", "jam", "pam",
				"new", "aye", "ani", "and", "ibm", "yap", "can", "pyx", "tar",
				"kin", "fog", "hum", "pip", "cup", "dye", "lyx", "jog", "nun",
				"par", "wan", "fey", "bus", "oak", "bad", "ats", "set", "qom",
				"vat", "eat", "pus", "rev", "axe", "ion", "six", "ila", "lao",
				"mom", "mas", "pro", "few", "opt", "poe", "art", "ash", "oar",
				"cap", "lop", "may", "shy", "rid", "bat", "sum", "rim", "fee",
				"bmw", "sky", "maj", "hue", "thy", "ava", "rap", "den", "fla",
				"auk", "cox", "ibo", "hey", "saw", "vim", "sec", "ltd", "you",
				"its", "tat", "dew", "eva", "tog", "ram", "let", "see", "zit",
				"maw", "nix", "ate", "gig", "rep", "owe", "ind", "hog", "eve",
				"sam", "zoo", "any", "dow", "cod", "bed", "vet", "ham", "sis",
				"hex", "via", "fir", "nod", "mao", "aug", "mum", "hoe", "bah",
				"hal", "keg", "hew", "zed", "tow", "gog", "ass", "dem", "who",
				"bet", "gos", "son", "ear", "spy", "kit", "boy", "due", "sen",
				"oaf", "mix", "hep", "fur", "ada", "bin", "nil", "mia", "ewe",
				"hit", "fix", "sad", "rib", "eye", "hop", "haw", "wax", "mid",
				"tad", "ken", "wad", "rye", "pap", "bog", "gut", "ito", "woe",
				"our", "ado", "sin", "mad", "ray", "hon", "roy", "dip", "hen",
				"iva", "lug", "asp", "hui", "yak", "bay", "poi", "yep", "bun",
				"try", "lad", "elm", "nat", "wyo", "gym", "dug", "toe", "dee",
				"wig", "sly", "rip", "geo", "cog", "pas", "zen", "odd", "nan",
				"lay", "pod", "fit", "hem", "joy", "bum", "rio", "yon", "dec",
				"leg", "put", "sue", "dim", "pet", "yaw", "nub", "bit", "bur",
				"sid", "sun", "oil", "red", "doc", "moe", "caw", "eel", "dix",
				"cub", "end", "gem", "off", "yew", "hug", "pop", "tub", "sgt",
				"lid", "pun", "ton", "sol", "din", "yup", "jab", "pea", "bug",
				"gag", "mil", "jig", "hub", "low", "did", "tin", "get", "gte",
				"sox", "lei", "mig", "fig", "lon", "use", "ban", "flo", "nov",
				"jut", "bag", "mir", "sty", "lap", "two", "ins", "con", "ant",
				"net", "tux", "ode", "stu", "mug", "cad", "nap", "gun", "fop",
				"tot", "sow", "sal", "sic", "ted", "wot", "del", "imp", "cob",
				"way", "ann", "tan", "mci", "job", "wet", "ism", "err", "him",
				"all", "pad", "hah", "hie", "aim", "ike", "jed", "ego", "mac",
				"baa", "min", "com", "ill", "was", "cab", "ago", "ina", "big",
				"ilk", "gal", "tap", "duh", "ola", "ran", "lab", "top", "gob",
				"hot", "ora", "tia", "kip", "han", "met", "hut", "she", "sac",
				"fed", "goo", "tee", "ell", "not", "act", "gil", "rut", "ala",
				"ape", "rig", "cid", "god", "duo", "lin", "aid", "gel", "awl",
				"lag", "elf", "liz", "ref", "aha", "fib", "oho", "tho", "her",
				"nor", "ace", "adz", "fun", "ned", "coo", "win", "tao", "coy",
				"van", "man", "pit", "guy", "foe", "hid", "mai", "sup", "jay",
				"hob", "mow", "jot", "are", "pol", "arc", "lax", "aft", "alb",
				"len", "air", "pug", "pox", "vow", "got", "meg", "zoe", "amp",
				"ale", "bud", "gee", "pin", "dun", "pat", "ten", "mob"));
		System.out.println(ladder.ladderLength(start, end, dict));

	}
}
