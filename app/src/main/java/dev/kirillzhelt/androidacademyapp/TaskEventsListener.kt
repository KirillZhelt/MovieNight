package dev.kirillzhelt.androidacademyapp

interface TaskEventContract {

    interface Lifecycle {
        fun onPreExecute()
        fun onPostExecute()
        fun onProgressUpdate(progress: Int)
    }

    interface Operationable {
        fun createTask()
        fun startTask(): Boolean?
        fun cancelTask()
    }
}