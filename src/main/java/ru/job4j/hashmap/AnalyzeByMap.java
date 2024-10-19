package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int countGrade = 0;
        int totalScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject: pupil.subjects()) {
                countGrade++;
                totalScore += subject.score();
            }
        }
        return (double) totalScore / countGrade;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            String pupilName = pupil.name();
            for (Subject subject : pupil.subjects()) {
                map.put(pupilName, subject.score() + map.getOrDefault(pupilName, 0));
            }
        }
        double countSubject = pupils.get(0).subjects().size();
        for (String pupilName : map.keySet()) {
            labels.add(new Label(pupilName, map.get(pupilName) / countSubject));
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score() + map.getOrDefault(subject.name(), 0));
            }
        }
        for (String name : map.keySet()) {
            labels.add(new Label(name, (double) map.get(name) / pupils.size()));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int pupilScore = 0;
            for (Subject subject : pupil.subjects()) {
                pupilScore += subject.score();
            }
            labels.add(new Label(pupil.name(), pupilScore));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), subject.score() + map.getOrDefault(subject.name(), 0));
            }
        }
        for (String name : map.keySet()) {
            labels.add(new Label(name, map.get(name)));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
