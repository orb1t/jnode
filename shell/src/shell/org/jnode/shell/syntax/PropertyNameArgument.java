package org.jnode.shell.syntax;

import org.jnode.driver.console.CompletionInfo;
import org.jnode.shell.CommandLine.Token;

public class PropertyNameArgument extends Argument<String> {
    
    public PropertyNameArgument(String label, int flags, String description) {
        super(label, flags, new String[0], description);
    }

    public PropertyNameArgument(String label, int flags) {
        this(label, flags, null);
    }

    public PropertyNameArgument(String label) {
        this(label, 0);
    }
    
    @Override
    protected void doAccept(Token token) throws CommandSyntaxException {
        addValue(token.token);
    }
    
    @Override
    public void complete(CompletionInfo completion, String partial) {
        for (Object key : System.getProperties().keySet()) {
            String name = (String) key;
            if (name.startsWith(partial)) {
                completion.addCompletion(name);
            }
        }
    }

    @Override
    protected String argumentKind() {
        return "property";
    }

}