const express = require('express');
const bodyParser = require('body-parser');
const ejs = require('ejs');

const app = express();
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.set('view engine', 'ejs');
const mongoose = require('mongoose');
mongoose.connect('mongodb://0.0.0.0:27017/students');
const db = mongoose.connection;
const path = require('path');

app.use(express.static(path.join(__dirname, 'public')));

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'public', 'index.html'));
});

db.on('error', console.error.bind(console, 'connection error:'));
db.once('open', function() {
  console.log('MongoDB database connection successful');
});

const studentSchema = new mongoose.Schema({
  name: String,
  studentNumber: String,
  email: String,
  courses: [String],
  gpa: Number
});

const Student = mongoose.model('Student', studentSchema);

app.post('/sign_up', function(req, res) {
  const { name, studentNumber, email, courses, gpa } = req.body;

  const newStudent = new Student({
    name,
    studentNumber,
    email,
    courses: courses.split(',').map(course => course.trim()),
    gpa: parseFloat(gpa),
  });
  
  newStudent.save()
    .then(student => {
      console.log('Inserted new student:', student);
      res.redirect('success.html');
    })
    .catch(err => {
      console.error(err);
      res.status(500).send('Error saving student to database');
    });
  
});



// route to handle DELETE request to /delete
app.delete('/delete', (req, res) => {
  const studentNumber = req.body.studentNumber;
  db.collection('students').findOneAndDelete({ studentNumber }, (err, result) => {
    if (err) {
      console.error(err);
      return res.status(500).send('Internal server error');
    }
    console.log(result);
   
    res.send(`Student with student number ${studentNumber} has been deleted`);
    console.log('Student deleted successfully');
  });
});


  app.get('/students', async (req, res) => {
    try {
      const students = await Student.find({});
      res.render('students', { students });
    } catch (error) {
      console.error(error);
      res.status(500).send('Internal server error');
    }
  });

// app.listen(3000, () => {
//   console.log('App listening on port 3000');
// });
const server = app.listen(3000, () => {
  console.log('App listening on port 3000');
});

server.on('error', (err) => {
  console.error(`Server error: ${err}`);
});
