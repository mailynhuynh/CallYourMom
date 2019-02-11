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
  var sql = "INSERT INTO users (name, email) VALUES ?";
  var values = [
    ['John', 'jhwagner@iastate.edu'],
    ['Zoe', 'zsanders@iastate.edu'],
    ['Tzu-Han', 'piano@iastate.edu'],
  ];
  con.query(sql, [values], function (err, result) {
    if (err) throw err;
    console.log("Number of records inserted: " + result.affectedRows);
  });
});
