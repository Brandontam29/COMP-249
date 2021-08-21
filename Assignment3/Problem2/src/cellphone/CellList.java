package cellphone;

public class CellList implements Cloneable {

	// inner class cellnode
	private class CellNode {
		private CellPhone CellPhone;
		private CellNode link;

		public CellNode() {
			CellPhone = null;
			link = null;
		}

		public CellNode(CellPhone phone, CellNode node) {
			CellPhone = phone;
			link = node;
		}

		public CellNode(CellNode original) {
			CellPhone = new CellPhone(original.CellPhone, original.CellPhone.getSerialNum());
			link = original.link;
		}

		public CellNode clone() {
			return new CellNode(this);
		}

		public CellPhone getCellPhone() {
			return new CellPhone(this.CellPhone, this.CellPhone.getSerialNum());
		}

		public CellNode getLink() {
			return link;
		}

		public void setCellPhone(CellPhone cellPhone) {
			CellPhone = new CellPhone(cellPhone, cellPhone.getSerialNum());
		}

		public void setLink(CellNode link) {

			this.link = link;
		}
	}

	private CellNode head;
	private int size = 0;

	public CellList() {
		head = null;
	}

	public CellList(CellList list) {
		if (list == null)
			throw new NullPointerException();
		if (list.head == null)
			head = null;
		else
			head = copyOf(list.head);
	}

	private CellNode copyOf(CellNode node) {
		CellNode position = node;
		CellNode newHead;
		CellNode end = null;

		newHead = new CellNode(position.CellPhone, null);
		end = newHead;
		position = position.link;

		while (position != null) {
			end.link = new CellNode(position.CellPhone, null);
			end = end.link;
			position = position.link;
		}

		return newHead;
	}

	public void addToStart(CellPhone add) {
		if (add == null)
			return;
		head = new CellNode(add, head);
		size++;
	}

	public void insertAtIndex(CellPhone obj, int index) {
		if (index < 0 || index >= size)
			return;

		CellNode temp = new CellNode(obj, null);
		int i = index - 1;

		CellNode node = head;

		for (int j = 0; node != null && i < size; j++) {
			if (j == i) {
				temp.link = node.link;
				node.link = temp;
			} else
				node = node.link;

		}
		size++;
	}

	public void deleteFromIndex(int index) {
		if (head == null || index >= size || index < 0)
			return;

		CellNode temp = head;

		if (index == 0) {
			head = temp.link;
			size--;
			return;
		}

		for (int i = 0; temp != null & i < index - 1; i++)
			temp = temp.link;

		if (temp == null || temp.link == null)
			return;

		CellNode link = temp.link.link;
		temp.link = link;
		size--;
	}

	public void deleteFromStart() {
		if (head == null)
			return;
		else
			head = head.link;
		size--;
	}

	public void replaceAtIndex(CellPhone obj, int index) {
		CellNode node = head;
		CellNode previous = null;

		if (index >= size || node == null || obj == null)
			return;

		for (; node != null && index >= 0; index--) {
			previous = node;
			node = node.link;
		}

		if (previous != null)
			previous.CellPhone = obj;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (this.getClass() != obj.getClass())
			return false;
		else {
			CellList chosenone = (CellList) obj;

			if (this.size != chosenone.size)
				return false;

			CellNode position = this.head;
			CellNode position2 = chosenone.head;

			while (position != null) {
				if (!position.CellPhone.equals(position2.CellPhone))
					return false;
				position = position.link;
				position2 = position2.link;
			}
			return true;
		}
	}

	public void showContents() {
		CellNode node = head;
		try {
			while (node != null) {
				for (int i = 0; i < 3; i++) {
					System.out.print(node.CellPhone);
					node = node.link;
				}
				System.out.println("");
			}
			System.out.println("X");
		} catch (NullPointerException e) {
			System.out.println("X");
		}
	}

	public CellNode find(long serialNum) {
		CellNode node = head;
		CellPhone Position;
		int i = 0;

		while (node != null) {
			Position = node.CellPhone;
			if (Position.getSerialNum() == serialNum) {
				System.out.println(i + " iterations with item #" + serialNum + " found");
				return node;
			}
			node = node.link;
			i++;
		}
		System.out.println(i + " iterations but item #" + serialNum + " not found");
		return null;
	}

	public boolean contains(long serialNum) {
		CellNode result = find(serialNum);
		if (result == null)
			return false;
		else
			return true;
	}

}
