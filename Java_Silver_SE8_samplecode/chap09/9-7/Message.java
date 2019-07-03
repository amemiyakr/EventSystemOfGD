class Message {
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder();
        String msg = "Thankyou";
        sb.append("Thank").append("you");
        if(msg == sb.toString()) {
            System.out.println("Same Object");
        }
        if(sb.equals(msg.toString())) {
            System.out.println("Same String");
        }
    }
}