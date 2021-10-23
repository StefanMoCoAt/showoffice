package com.stefanmocoat.showoffice.stuff;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
//import org.junit.jupiter.api.Test;

public class Associations {

	@Test
	public void test() {
		TurnierObj t = new TurnierObj("Foo");

		BewerbObj b1 = new BewerbObj("Bewerb 1");
		BewerbObj b2 = new BewerbObj("Bewerb 2");
		BewerbObj b3 = new BewerbObj("Bewerb 3");
		BewerbObj b4 = new BewerbObj("Bewerb 4");

		assertNull(b1.getTurnier());
		assertNull(b2.getTurnier());

		t.addBewerb(b1);
		assertNotNull(b1.getTurnier());
		assertNull(b2.getTurnier());
		assertSame(t, b1.getTurnier());

		t.removeBewerb(b1);
		assertNull(b1.getTurnier());
		assertNull(b2.getTurnier());

		List<BewerbObj> bewerbe = new ArrayList<>();
		bewerbe.add(b1);
		bewerbe.add(b2);
		bewerbe.add(b3);
		bewerbe.add(b4);

		System.out.println(bewerbe);

		bewerbe.sort((o1, o2) -> {
			return o2.getName().compareTo(o1.getName());
		});
		System.out.println(bewerbe);
	}

	static class TurnierObj {

		private String name;

		List<ReiterObj> reiter = new ArrayList<>();
		List<BewerbObj> bewerbe = new ArrayList<>();

		public TurnierObj(String name) {
			this.name = name;
		}

		public void addBewerb(BewerbObj b) {
			if (b.getTurnier() != this) {
				b.setTurnier(this);
			}
			bewerbe.add(b);
		}

		public void addReiter(ReiterObj r) {
			reiter.add(r);
		}

		public void removeBewerb(BewerbObj b) {
			b.setTurnier(null);
			bewerbe.remove(b);
		}

		public void removeReiter(ReiterObj r) {
			reiter.remove(r);
		}

		public List<BewerbObj> getBewerbe() {
			return Collections.unmodifiableList(bewerbe);
		}

	}

	/**
	 * Reiter Obj existiert auch dann, wenn es kein Turnier gibt. Wird ein Tournier
	 * entfernt, bleiben die Reiter dennoch bestehen (Association).
	 */
	static class ReiterObj {
		private String name;

		public ReiterObj(String name) {
			this.name = name;
		}

	}

	/**
	 * Bewerb Obj existiert nur INNERHALB des Turniers. Wird das Tournier entfernt,
	 * werden auch alle Bewerbe entfernt (Aggregation).
	 * <p>
	 * Ein Bewerb hat IMMER ein Tournier! Ein Tournier kann 0->n Bewerbe haben.
	 * <p>
	 * Dh, von einem Bewerb kann man IMMER auf genau 1 Turnier schließen.
	 */
	static class BewerbObj {
		private String name;

		private TurnierObj turnier;

		public BewerbObj(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public TurnierObj getTurnier() {
			return turnier;
		}

		public void setTurnier(TurnierObj turnier) {
			this.turnier = turnier;
		}

		@Override
		public String toString() {
			return "BewerbObj [name=" + name + "]";
		}

	}

}
