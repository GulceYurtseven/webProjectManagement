package com.example.demo.services;

import com.example.demo.entities.Tasks;
import com.example.demo.repos.TaskRepository;
import com.example.demo.request.TaskCreateRequest;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Tasks> getAllTasks() {
        return taskRepository.findAll();
    }

    public Tasks saveTask(TaskCreateRequest taskCreateRequest) {
        Tasks task = new Tasks();
        task.setDescription(taskCreateRequest.getDescription());
        task.setStatus(taskCreateRequest.getStatus());

        // ProjectId'yi ayarla (Eğer gerekliyse)
        // task.setProjectId(taskCreateRequest.getProjectId());

        return taskRepository.save(task);
    }

    public Tasks getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }


    public Tasks updateTask(Long taskId, TaskCreateRequest taskCreateRequest) {
        Optional<Tasks> existingTaskOptional = taskRepository.findById(taskId);

        if (existingTaskOptional.isPresent()) {
            Tasks existingTask = existingTaskOptional.get();

            // Güncelleme işlemleri
            if (taskCreateRequest.getDescription() != null) {
                existingTask.setDescription(taskCreateRequest.getDescription());
            }

            if (taskCreateRequest.getStatus() != null) {
                existingTask.setStatus(taskCreateRequest.getStatus());
            }

            // Eğer projeyi güncellemek istiyorsanız
            if (taskCreateRequest.getProjectId() != null) {
                // existingTask.setProjectId(taskCreateRequest.getProjectId());
                // Eğer projenin tamamını güncellemek istiyorsanız, projeyi alıp set edebilirsiniz
                // existingTask.setProject(newProject);
            }

            // Daha sonra güncellenmiş görevi kaydedin
            return taskRepository.save(existingTask);
        } else {
            // Eğer taskId'ye sahip bir görev bulunamazsa null dönebilir veya uygun bir hata yönetimi yapabilirsiniz.
            return null;
        }
    }
    // Burada gerekli güncelleme işlemlerini yapabilirsiniz
    // Örneğin: Task'ın description ve status alanlarını güncelleyebilirsiniz

    // Eğer projeyi de güncellemek istiyorsanız, ProjectId'yi de ayarlayabilirsiniz

    // Daha sonra taskRepository.save() ile güncellenmiş görevi kaydedebilirsiniz

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
