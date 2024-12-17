# Quiz_App_In_Spring_Boot
To create the API endpoints for a quiz app in Spring Boot.
 
Steps to Implement:
1. Set up Spring Boot Project.
   Create a new Spring Boot application with dependencies:
   Spring Web
   Spring Data JPA
   H2 Database
   Spring Boot DevTools (optional)
2. Create Entity classes for User, Question, and Answer.
3. Create repositories for accessing the database.
4. Implement services for quiz logic.
5. Implement controller for handling API requests.
6. Configure H2 database for in-memory storage.
 
Assumptions:
1. User: A single user will be created at the start. This user can take multiple quiz sessions and answer multiple questions.
2. Quiz Session: A session will be initiated when the user starts the quiz.
3. Questions: Questions will be pre-seeded in the database as multiple-choice questions.
4. Answers: The user can submit answers, and we will track whether they are correct or not.
5. Database: We'll use H2 in-memory database to store users, questions, and answers.
 
## Endpoints
1. **Start New Quiz Session**
   - **Endpoint**: `POST /api/quiz/start?userName=John Doe`
   - **Description**: Starts a new quiz session for the user.
 
2. **Get a Random Multiple Choice Question**
   - **Endpoint**: `GET /api/quiz/question`
   - **Description**: Retrieves a random multiple choice question from the database.
 
3. **Submit Answer**
   - **Endpoint**: `POST /api/quiz/submit?userId=1&questionId=1&answer=A`
   - **Description**: Submits the user's answer to a question.
 
4. **Get Quiz Results**
   - **Endpoint**: `GET /api/quiz/results?userId=1`
   - **Description**: Retrieves the total questions answered by the user with details on correct and incorrect submissions.
