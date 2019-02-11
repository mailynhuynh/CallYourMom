var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "password",
  database: "mydb"
});

con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  var sql ="CREATE TABLE users (name VARCHAR(255), email VARCHAR(255))"; 
  con.query(sql, function (err, result) {
    if (err) throw err;
    console.log("Table created");
  });
});
