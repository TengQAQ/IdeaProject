package com.ming.sellticket;


public class Demo3 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        TicketThread ticketThread = new TicketThread(ticket);
        Thread thread = new Thread(ticketThread);
    }

    private static class Ticket {
        private int ticket = 100;

        public int getTicket() {
            return ticket;
        }

        public void setTicket() {
            System.out.println("购买第"+ticket+"张"+ticket--);
        }
    }

    private static class TicketThread implements Runnable{
        // ticket对象代表着共享资源
        private Ticket ticket;

        public TicketThread(Ticket ticket) {
            this.ticket = ticket;
        }

        @Override
        public void run() {
            // 线程只关心是否有余票，以及卖票
            while (ticket.getTicket() > 0) {
                ticket.setTicket();
            }
        }
    }
}
