package ge.edu.ug.patterns.behavioral.mediator.chat;

public class ConcreteMember implements ChatMember{
    private String name;
    private ChatMediator chatMediator;

    public ConcreteMember(String name, ChatMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
        this.chatMediator.addMember(this);
    }

    @Override
    public void receiveMessage(String message) {
//        System.out.printf("%s received the message: %s\n", name, message);
    }

    @Override
    public void sendMessage(String message) {

        this.chatMediator.broadcastMessage(this, message);
    }

    @Override
    public String getName() {
        return name;
    }
}
