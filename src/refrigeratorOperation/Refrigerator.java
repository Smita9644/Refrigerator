package refrigeratorOperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class refrigerator class which contain three shelve small,medium and
 * large so that there are two methods in the table to add and get tje item
 */
public class Refrigerator {
	public int largeShelve;
	public int mediumShelve;
	public int smallShelve;

	public List<Item> objectInsideLargeShelve = new ArrayList<Item>();
	public List<Item> objectInsideMediumShelve = new ArrayList<Item>();;
	public List<Item> objectInsideSmallShelve = new ArrayList<Item>();;

	/**
	 * This is parameterless constructor in which we set fixed values of each shelve
	 */
	public Refrigerator() {
		this.largeShelve = 100;
		this.mediumShelve = 70;
		this.smallShelve = 50;
	}

	/** The given below is the method that we use to add item in refrigerator */
	public String addItemInRefrigerator(Item obj) {
		/**
		 * if size of given item is less than small shelve then we insert it in small
		 * shelve
		 */
		if (obj.getSize() <= this.smallShelve) {
			objectInsideSmallShelve.add(obj);
			this.smallShelve = this.smallShelve - obj.getSize();
			return (obj.getName() + "   is added in small Shelve");
		}
		/**
		 * if size of given item is less than medium shelve then we insert it in medium
		 * shelve
		 */
		else if (obj.getSize() <= this.mediumShelve) {
			objectInsideMediumShelve.add(obj);
			this.mediumShelve = this.mediumShelve - obj.getSize();
			return (obj.getName() + "  is added in medium Shelve");

		}
		/**
		 * if size of given item is less than large shelve then we insert it in large
		 * shelve
		 */
		else if (obj.getSize() <= this.largeShelve) {
			objectInsideLargeShelve.add(obj);
			this.largeShelve = this.largeShelve - obj.getSize();
			return (obj.getName() + "   is added in large Shelve");
		} else {
			/**
			 * if medium shelve and small shelve addition of both is equal to the item size
			 * and the amount of size consumed in small shevele is present in medium the we
			 * shift that to medium and new item is added in small
			 */
			if (this.mediumShelve + this.smallShelve == obj.getSize() && 50 - this.smallShelve == this.mediumShelve) {
				this.objectInsideMediumShelve.addAll(objectInsideSmallShelve);
				this.mediumShelve = this.mediumShelve - this.smallShelve;
				objectInsideSmallShelve.clear();
				this.smallShelve = 50;
				return this.addItemInRefrigerator(obj);

			}
			/**
			 * if medium shelve and large shelve addition of both is equal to the item size
			 * and the amount of size consumed in medium shelve is present in large the we
			 * shift that to large shelve and new item is added in medium
			 */
			else if (this.largeShelve + this.mediumShelve >= obj.getSize()
					&& 70 - this.mediumShelve <= this.largeShelve) {

				this.objectInsideLargeShelve.addAll(objectInsideMediumShelve);
				this.largeShelve = this.largeShelve - (70 - this.mediumShelve);
				System.out.println("large  " + this.largeShelve);
				objectInsideMediumShelve.clear();
				this.mediumShelve = 70;
				return this.addItemInRefrigerator(obj);

			}
			/**
			 * if small shelve and large shelve addition of both is equal to the item size
			 * and the amount of size consumed in small shelve is present in large the we
			 * shift that to large shelve and new item is added in small
			 */
			else if (this.largeShelve + this.smallShelve >= obj.getSize()
					&& 50 - this.smallShelve <= this.largeShelve) {

				this.objectInsideLargeShelve.addAll(objectInsideSmallShelve);
				this.largeShelve = this.largeShelve - (50 - this.smallShelve);
				objectInsideSmallShelve.clear();
				this.smallShelve = 50;
				this.addItemInRefrigerator(obj);

			} else {
				if (this.checkSpaceForItemInMediumSlave(obj)) {
					return (obj.getName() + "  is added in medium Shelve");
				} else if (this.checkSpaceForItemInSmallSlave(obj)) {
					return (obj.getName() + "  is added in small Shelve");
				} else {
					return ("No space avaibale");
				}

			}
		}
		return ("No space avaibale");

	}

	/**
	 * Here we check any item from small shelve is able to shift in medium shelve so
	 * that new element is added in small shelve
	 */
	public boolean checkSpaceForItemInMediumSlave(Item obj) {
		boolean status = false;
		for (Item object : this.objectInsideMediumShelve) {
			if (object.getSize() < obj.getSize() && this.mediumShelve + object.getSize() >= obj.getSize()
					&& this.largeShelve >= object.getSize()) {
				this.objectInsideLargeShelve.add(object);
				this.objectInsideMediumShelve.remove(object.getId());
				this.objectInsideMediumShelve.add(obj);
				this.mediumShelve = this.mediumShelve - obj.getSize();
				status = true;
				break;
			}
		}
		return status;
	}

	/**
	 * Here we check any item from medium shelve is able to shift in large shelve so
	 * that new element is added in medium shelve
	 */
	public boolean checkSpaceForItemInSmallSlave(Item obj) {
		boolean status = false;
		for (Item object : this.objectInsideSmallShelve) {
			if (object.getSize() < obj.getSize() && this.smallShelve + object.getSize() >= obj.getSize()
					&& this.mediumShelve >= object.getSize()) {
				this.objectInsideMediumShelve.add(object);
				this.objectInsideSmallShelve.remove(object.getId());
				this.objectInsideSmallShelve.add(obj);
				this.smallShelve = this.smallShelve - obj.getSize();
				status = true;
				break;

			}

		}
		return status;
	}

	/**
	 * In the below method we check that the givent item is present in Refrigerator
	 * or not
	 */
	public String getSelectedItemformRefrigerator(Item item) {
		String result = "Item is not present ";
		if (item != null) {
			for (Item obj : this.objectInsideSmallShelve) {
				if (obj.equals(item)) {
					result = "Item is present in small shelve";
				}
			}
			for (Item obj : this.objectInsideMediumShelve) {
				if (obj.equals(item)) {
					result = "Item is present in medium shelve";
				}
			}
			for (Item obj : this.objectInsideLargeShelve) {
				if (obj.equals(item)) {
					result = "Item is present in large shelve";
				}
			}
		} else
			result = "Item should not  be null ";
		return result;
	}

}
