const xhr = new XMLHttpRequest();
xhr.open('GET', 'http://dev.shforce.com/res/weather.json');
xhr.onload = function() {
  if (xhr.status === 200) {
    const data = JSON.parse(xhr.responseText);
    console.log(data);
  } else {
    console.error('Request failed. Returned status of ' + xhr.status);
  }
};
xhr.send()