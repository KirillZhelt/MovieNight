package dev.kirillzhelt.androidacademyapp.tasks

interface TaskEventContract {

    interface Lifecycle {
        fun onPreExecute()
        fun onPostExecute()
        fun onProgressUpdate(progress: Int)
    }

    interface Task {
        fun createTask()
        fun startTask(): Boolean?
        fun cancelTask()
    }
}