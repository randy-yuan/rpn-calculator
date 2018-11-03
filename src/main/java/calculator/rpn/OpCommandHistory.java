package calculator.rpn;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Optional;

/**
 * Created by randy on 18/10/30.
 */
public class OpCommandHistory {
  private final int DEFAULT_HISTORY_NUM = 16;

  private int maxHistory = DEFAULT_HISTORY_NUM;

  private Deque<OpCommand> commands;

  public OpCommandHistory() {
    commands = new LinkedList<>();
  }

  public void setMaxHistory(int maxHistory) {
    this.maxHistory = maxHistory;
  }

  public Optional<OpCommand> pop() {
    return Optional.ofNullable(commands.pollLast());
  }

  public void push(OpCommand command) {
    if (commands.size() == maxHistory) {
      commands.pollFirst();
    }
    commands.offerLast(command);
  }

  public void clear() {
    commands.clear();
  }
}
