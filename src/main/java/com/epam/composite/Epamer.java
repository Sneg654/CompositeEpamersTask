package com.epam.composite;

import java.util.*;
import java.util.function.Consumer;

public class Epamer implements Iterable<Epamer> {
    private String fullName;
    private String title;
    private List<Epamer> team = new ArrayList<>();
    private final static String NEXT_LVL="---";

    public Epamer() {
    }

    public Epamer(String fullName, String title) {
        this.fullName = fullName;
        this.title = title;
    }


    public List<Epamer> getTeam() {
        return team;
    }


    public boolean add(Epamer epamer) {
        return team.add(epamer);
    }

    public boolean remove(Epamer epamer) {
        return team.remove(epamer);
    }

    public String getFullName() {
        return fullName;
    }



    public String getTitle() {
        return title;
    }



    public Epamer searchByFullName(String fullName) {
        if (this.getFullName().equalsIgnoreCase(fullName)) {
            return this;
        }
        Stack<Iterator<Epamer>> stack = new Stack<>();
        Iterator<Epamer> currentIterator = iterator();
        stack.add(currentIterator);
        while (!stack.isEmpty()) {
            currentIterator = stack.peek();
            while (currentIterator.hasNext()) {
                Epamer epamer = currentIterator.next();
                if (epamer.getFullName().equalsIgnoreCase(fullName)) {
                    return epamer;
                }
                stack.add(epamer.iterator());
                currentIterator = epamer.iterator();
            }
            stack.pop();
        }
        return null;
    }

    public void addEpamer(Epamer lead, Epamer teamMember) {
        if (this.equals(lead)) {
            this.add(teamMember);
        }
        Stack<Iterator<Epamer>> stack = new Stack<>();
        Iterator<Epamer> currentIterator = iterator();
        stack.add(currentIterator);
        while (!stack.isEmpty()) {
            currentIterator = stack.peek();
            while (currentIterator.hasNext()) {
                Epamer epamer = currentIterator.next();
                if (epamer.equals(lead)) {
                    epamer.add(teamMember);
                    return;
                }
                stack.add(epamer.iterator());
                currentIterator = epamer.iterator();
            }
            stack.pop();
        }
    }

    public void removeByFullName(String fullName) {
        Stack<Iterator<Epamer>> stack = new Stack<>();
        Stack<Epamer> leaders = new Stack<>();
        Iterator<Epamer> currentIterator = iterator();
        leaders.add(this);
        stack.add(currentIterator);
        while (!stack.isEmpty()) {
            currentIterator = stack.peek();
            while (currentIterator.hasNext()) {
                Epamer epamer = currentIterator.next();
                if (epamer.getFullName().equalsIgnoreCase(fullName)) {
                    leaders.peek().team.remove(epamer);
                    return;
                }
                stack.add(epamer.iterator());
                leaders.add(epamer);
                currentIterator = epamer.iterator();
            }
            stack.pop();
            leaders.pop();
        }
    }

    public void showHierachy(String space) {
        System.out.println(space + this.getFullName());
        System.out.println(space + this.getTitle());
        if (team.size() > 0) {
            for (Epamer ep : team) {
                ep.showHierachy(space +NEXT_LVL );
            }
        }
    }

    @Override
    public Iterator<Epamer> iterator() {
        return this.team.iterator();
    }

    @Override
    public void forEach(Consumer<? super Epamer> action) {
        this.team.forEach(action);
    }

    @Override
    public Spliterator<Epamer> spliterator() {
        return this.team.spliterator();
    }

    @Override
    public String toString() {
        return fullName + "     " + title;
    }
}