class program{
    public static void main (String[] args) throws java.lang.Exception {
        Message myMessage = new Message(500, 1, "All cats are black in the dark.");
        myMessage.editText("All cats are grey in the dark.");
        System.out.println(myMessage.length());
        Message message2 = new Message(500, 0, "Much ado about nothing.");
        message2.editText("Henry V");
        System.out.println(message2.length());
        Phone phone = new Phone("Manya", 2128506, message2);
        phone.sendMessage(message2);
        phone.getLastMessage();
        System.out.println(phone.getLastMessage().getText());
    }
}

class Message {
    private int maxLength;
    private int minLength;
    private String text;

    public Message(int maxLength, int minLength, String text) {
        this.maxLength = maxLength;
        this.minLength = minLength;
        this.text = text;
    }

    public int length() {
        return text.length();
    }

    public String getText() {
        return text;
    }

    public String editText(String newText) {
        text = newText;
        return text;
    }
}

class Phone {

    private String contactName;
    private int phoneNumber;
    private Message lastMessage;

    public Phone(String contactName, int phoneNumber, Message lastMessage) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.lastMessage = lastMessage;
    }

    public String sendMessage(Message message) {
        if (message.length() < 400)	{
            lastMessage = message;
            return "The message was sent";
        }

        else {
            return "Failed to send message";
        }
    }

    public Message getLastMessage() {
        return lastMessage;
    }

}