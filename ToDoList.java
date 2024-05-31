package package3;


public class ToDoList {
	Node head;

	public void addToDo(Task task) {
		Node newNode = new Node(task);
		if (head == null) {
			head = newNode;
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
		}
	}

	public void markToDoAsCompleted(String title) {
		Node temp = head;
		while (temp != null) {
			if (temp.task.getTitle().equals(title)) {
				temp.task.markCompleted();
				break;
			}
			temp = temp.next;
		}
	}

	public void viewToDoList() {
		Node temp = head;
		while (temp != null) {
			System.out.println("Task: " + temp.task.getTitle());
			System.out.println("Description: " + temp.task.getDescription());
			System.out.println("Completed: " + temp.task.isCompleted());
			System.out.println();
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		ToDoList toDoList = new ToDoList();
		toDoList.addToDo(new Task("Task 1", "Description 1"));
		toDoList.addToDo(new Task("Task 2", "Description 2"));
		toDoList.addToDo(new Task("Task 3", "Description 3"));
		toDoList.viewToDoList();
		toDoList.markToDoAsCompleted("Task 2");
		toDoList.viewToDoList();
	}
}