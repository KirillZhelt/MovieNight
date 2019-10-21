package dev.kirillzhelt.androidacademyapp

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