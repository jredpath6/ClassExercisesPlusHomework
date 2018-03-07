package headfirst.command.undo;

import java.util.ListIterator;
import java.util.Stack;

//
// This is the invoker
//
public class RemoteControlWithUndo {
	private Command[] onCommands;
	private Command[] offCommands;
	private Command undoCommand;
	private Stack<Command> commandStack = new Stack();

	public RemoteControlWithUndo() {
		onCommands = new Command[7];
		offCommands = new Command[7];

		Command noCommand = new NoCommand();
		for (int i = 0; i < 7; i++) {
			onCommands[i] = noCommand;
			offCommands[i] = noCommand;
		}
		undoCommand = noCommand;
	}

	public void offButtonWasPushed(int slot) {
		offCommands[slot].execute();
		commandStack.push(offCommands[slot]);
	}

	public void onButtonWasPushed(int slot) {
		onCommands[slot].execute();
		commandStack.push(onCommands[slot]);
	}

	public void setCommand(int slot, Command onCommand, Command offCommand) {
		onCommands[slot] = onCommand;
		offCommands[slot] = offCommand;
	}

	@Override
	public String toString() {
		ListIterator<Command> iter = commandStack.listIterator(commandStack.size());
		StringBuffer stringBuff = new StringBuffer();
		stringBuff.append("\n------ Remote Control -------\n");
		for (int i = 0; i < onCommands.length; i++) {
			stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName() + "    "
					+ offCommands[i].getClass().getName() + "\n");
		}
		stringBuff.append("[undo] " + undoCommand.getClass().getName() + "\n");
		if (iter.hasPrevious()) {
			stringBuff.append("[undoList] " + iter.previous().getClass().getName());
		}
		return stringBuff.toString();
	}

	public void undoButtonWasPushed() {
		if (commandStack.elements().hasMoreElements()) {
			commandStack.pop().undo();
		}
	}
}
