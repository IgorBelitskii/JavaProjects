package tel_ran.collections.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import tel_ran.collections.TreeSet;

public class TreeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		TreeSet<Integer> tree = new TreeSet<>();
		Random random = new Random();
		for (int i = 0; i < 7; i++) {
			tree.add(random.nextInt(1000));
		}
		tree.displayTreeLine();
		System.out.println();
		tree.displayTreeRight();
		System.out.println("Высота дерева " + tree.height);
		System.out.println("Ширина дерева " + tree.width);
		System.out.println("Ширина др. функция " + tree.width());
		System.out.println("Высота др. функция " + tree.height());
		tree.balance();
		System.out.println("After balanse");
		System.out.println("Ширина др. функция " + tree.width());
		System.out.println("Высота др. функция " + tree.height());
		tree.displayTreeRight();
		// int arr[] = new int[12];
	}
	@Test
	public void BalanseTest() {
		int n_elements[] = { 7, 15, 31, 63, 127 };
		int n_heights[] = { 3, 4, 5, 6, 7 };
		int n_widths[] = { 4, 8, 16, 32, 64 };
		for (int i = 0; i < n_elements.length; i++) {
			TreeSet<Integer> tree1 = new TreeSet<>();
			Random random1 = new Random();
			for (int j = 0; j < n_elements[i]; j++) {
				tree1.add(random1.nextInt(1000));
			}

			tree1.listTree = new ArrayList<>();
			tree1.findNodesLine(tree1.getRoot());
			while (tree1.listTree.size() < n_elements[i]) {
				tree1.add(random1.nextInt(100));
				tree1.listTree = new ArrayList<>();
				tree1.findNodesLine(tree1.getRoot());
			}

			System.out.println("Tree N" + i);
			tree1.displayTreeRight();
			tree1.balance();
			tree1.displayTreeRight();
			assertEquals(n_heights[i], tree1.height());
			assertEquals(n_widths[i], tree1.width());
		}

	}

}
