package org.jnode.apps.jpartition.commands;

import org.jnode.apps.jpartition.commands.framework.CommandException;
import org.jnode.driver.bus.ide.IDEDevice;

public class CreatePartitionCommand extends BasePartitionCommand {
	final private long start;
	final private long size;

	public CreatePartitionCommand(IDEDevice device, int partitionNumber, long start, long size) {
		super("create partition", device, partitionNumber);
		this.start = start;
		this.size = size;
	}

	@Override
	final protected void doExecute() throws CommandException {
//		PartitionHelper helper = createPartitionHelper();
//		try {
//
//			helper.write();
//		} catch (IOException e) {
//			throw new CommandException(e);
//		}
	}

	@Override
	public String toString() {
		return "create partition [" + start + ", " + (start+size-1) + "] on device " + device.getId();
	}
}
