class Process {
    int processId;
    int burstTime;
    int priority;
    int remainingBurstTime;
    Process next;

    Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.remainingBurstTime = burstTime;
        this.next = null;
    }
}

class Prob6 {
    Process head;
    Process tail;
    int timeQuantum;

    Prob6(int timeQuantum) {
        head = null;
        tail = null;
        this.timeQuantum = timeQuantum;
    }

    void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = newProcess;
            tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            newProcess.next = head;
        }
    }

    void removeProcess(int processId) {
        Process current = head;
        Process prev = null;

        if (current != null && current.processId == processId) {
            head = current.next;
            tail.next = head;
            return;
        }

        do {
            prev = current;
            current = current.next;
            if (current != null && current.processId == processId) {
                prev.next = current.next;
                if (current == tail) {
                    tail = prev;
                }
                return;
            }
        } while (current != head);
    }

    void scheduleProcesses() {
        Process current = head;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int numProcesses = 0;
        
        Process temp = head;
        if (temp != null) {
            do {
                numProcesses++;
                temp = temp.next;
            } while (temp != head);
        }

        int totalTime = 0;
        while (numProcesses > 0) {
            if (current.remainingBurstTime > 0) {
                int executedTime = Math.min(timeQuantum, current.remainingBurstTime);
                current.remainingBurstTime -= executedTime;
                totalTime += executedTime;
                System.out.println("Process " + current.processId + " executed for " + executedTime + " units.");

                if (current.remainingBurstTime == 0) {
                    int turnaroundTime = totalTime;
                    int waitingTime = turnaroundTime - current.burstTime;
                    totalWaitingTime += waitingTime;
                    totalTurnaroundTime += turnaroundTime;
                    System.out.println("Process " + current.processId + " completed. Waiting Time: " + waitingTime + ", Turnaround Time: " + turnaroundTime);
                    removeProcess(current.processId);
                    numProcesses--;
                }
            }
            current = current.next;
            displayQueue();
        }

        System.out.println("\nAverage Waiting Time: " + (double) totalWaitingTime / numProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / numProcesses);
    }

    void displayQueue() {
        if (head == null) {
            System.out.println("No processes available");
            return;
        }

        Process current = head;
        System.out.print("Current Process Queue: ");
        do {
            System.out.print("P" + current.processId + "(" + current.remainingBurstTime + " remaining) ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        Prob6 roundRobinScheduler = new Prob6(4);

        roundRobinScheduler.addProcess(1, 10, 1);
        roundRobinScheduler.addProcess(2, 5, 2);
        roundRobinScheduler.addProcess(3, 8, 3);
        roundRobinScheduler.addProcess(4, 6, 1);

        System.out.println("Starting Round Robin Scheduling:\n");
        roundRobinScheduler.scheduleProcesses();
    }
}
