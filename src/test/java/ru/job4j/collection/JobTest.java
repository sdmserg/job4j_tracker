package ru.job4j.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 4),
                new Job("Teacher", 2),
                new Job("Actor", 1),
                new Job("Cook", 3),
                new Job("Engineer", 5),
                new Job("Builder", 1)
        );
        jobs.sort(new JobAscByName());
        List<Job> expected = Arrays.asList(
                new Job("Actor", 1),
                new Job("Builder", 1),
                new Job("Cook", 3),
                new Job("Doctor", 4),
                new Job("Engineer", 5),
                new Job("Teacher", 2)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 4),
                new Job("Teacher", 2),
                new Job("Builder", 1),
                new Job("Cook", 3),
                new Job("Engineer", 5),
                new Job("Actor", 1)
        );
        jobs.sort(new JobAscByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Teacher", 2),
                new Job("Cook", 3),
                new Job("Doctor", 4),
                new Job("Engineer", 5)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 4),
                new Job("Teacher", 2),
                new Job("Builder", 1),
                new Job("Cook", 3),
                new Job("Engineer", 5),
                new Job("Actor", 1)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Teacher", 2),
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Builder", 1),
                new Job("Actor", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Doctor", 4),
                new Job("Teacher", 2),
                new Job("Builder", 1),
                new Job("Cook", 3),
                new Job("Engineer", 5),
                new Job("Actor", 1)
        );
        jobs.sort(new JobDescByPriority());
        List<Job> expected = Arrays.asList(
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Teacher", 2),
                new Job("Builder", 1),
                new Job("Actor", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobAscByNameWithAscPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Teacher", 2),
                new Job("Engineer", 3),
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Doctor", 7),
                new Job("Cook", 1),
                new Job("Teacher", 6),
                new Job("Engineer", 2),
                new Job("Builder", 4),
                new Job("Actor", 5)
        );
        Comparator<Job> combine = new JobAscByName().thenComparing(new JobAscByPriority());
        jobs.sort(combine);
        List<Job> expected = Arrays.asList(
                new Job("Actor", 1),
                new Job("Actor", 5),
                new Job("Builder", 1),
                new Job("Builder", 4),
                new Job("Cook", 1),
                new Job("Cook", 3),
                new Job("Doctor", 4),
                new Job("Doctor", 7),
                new Job("Engineer", 2),
                new Job("Engineer", 3),
                new Job("Engineer", 5),
                new Job("Teacher", 2),
                new Job("Teacher", 6)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobAscByNameWithDescPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Teacher", 2),
                new Job("Engineer", 3),
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Doctor", 7),
                new Job("Cook", 1),
                new Job("Teacher", 6),
                new Job("Engineer", 2),
                new Job("Builder", 4),
                new Job("Actor", 5)
        );
        Comparator<Job> combine = new JobAscByName().thenComparing(new JobDescByPriority());
        jobs.sort(combine);
        List<Job> expected = Arrays.asList(
                new Job("Actor", 5),
                new Job("Actor", 1),
                new Job("Builder", 4),
                new Job("Builder", 1),
                new Job("Cook", 3),
                new Job("Cook", 1),
                new Job("Doctor", 7),
                new Job("Doctor", 4),
                new Job("Engineer", 5),
                new Job("Engineer", 3),
                new Job("Engineer", 2),
                new Job("Teacher", 6),
                new Job("Teacher", 2)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByNameWithAscPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Teacher", 2),
                new Job("Engineer", 3),
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Doctor", 7),
                new Job("Cook", 1),
                new Job("Teacher", 6),
                new Job("Engineer", 2),
                new Job("Builder", 4),
                new Job("Actor", 5)
        );
        Comparator<Job> combine = new JobDescByName().thenComparing(new JobAscByPriority());
        jobs.sort(combine);
        List<Job> expected = Arrays.asList(
                new Job("Teacher", 2),
                new Job("Teacher", 6),
                new Job("Engineer", 2),
                new Job("Engineer", 3),
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Doctor", 7),
                new Job("Cook", 1),
                new Job("Cook", 3),
                new Job("Builder", 1),
                new Job("Builder", 4),
                new Job("Actor", 1),
                new Job("Actor", 5)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByNameWithDescPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Teacher", 2),
                new Job("Engineer", 3),
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Doctor", 7),
                new Job("Cook", 1),
                new Job("Teacher", 6),
                new Job("Engineer", 2),
                new Job("Builder", 4),
                new Job("Actor", 5)
        );
        Comparator<Job> combine = new JobDescByName().thenComparing(new JobDescByPriority());
        jobs.sort(combine);
        List<Job> expected = Arrays.asList(
                new Job("Teacher", 6),
                new Job("Teacher", 2),
                new Job("Engineer", 5),
                new Job("Engineer", 3),
                new Job("Engineer", 2),
                new Job("Doctor", 7),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Cook", 1),
                new Job("Builder", 4),
                new Job("Builder", 1),
                new Job("Actor", 5),
                new Job("Actor", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobAscByPriorityWithDescName() {
        List<Job> jobs = Arrays.asList(
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Teacher", 2),
                new Job("Engineer", 3),
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Doctor", 7),
                new Job("Cook", 1),
                new Job("Teacher", 6),
                new Job("Engineer", 2),
                new Job("Builder", 4),
                new Job("Actor", 5)
        );
        Comparator<Job> combine = new JobAscByPriority().thenComparing(new JobDescByName());
        jobs.sort(combine);
        List<Job> expected = Arrays.asList(
                new Job("Cook", 1),
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Teacher", 2),
                new Job("Engineer", 2),
                new Job("Engineer", 3),
                new Job("Cook", 3),
                new Job("Doctor", 4),
                new Job("Builder", 4),
                new Job("Engineer", 5),
                new Job("Actor", 5),
                new Job("Teacher", 6),
                new Job("Doctor", 7)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenJobDescByPriorityWithAscName() {
        List<Job> jobs = Arrays.asList(
                new Job("Engineer", 5),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Teacher", 2),
                new Job("Engineer", 3),
                new Job("Builder", 1),
                new Job("Actor", 1),
                new Job("Doctor", 7),
                new Job("Cook", 1),
                new Job("Teacher", 6),
                new Job("Engineer", 2),
                new Job("Builder", 4),
                new Job("Actor", 5)
        );
        Comparator<Job> combine = new JobDescByPriority().thenComparing(new JobAscByName());
        jobs.sort(combine);
        List<Job> expected = Arrays.asList(
                new Job("Doctor", 7),
                new Job("Teacher", 6),
                new Job("Actor", 5),
                new Job("Engineer", 5),
                new Job("Builder", 4),
                new Job("Doctor", 4),
                new Job("Cook", 3),
                new Job("Engineer", 3),
                new Job("Engineer", 2),
                new Job("Teacher", 2),
                new Job("Actor", 1),
                new Job("Builder", 1),
                new Job("Cook", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }
}