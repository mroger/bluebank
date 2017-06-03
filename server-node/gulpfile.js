let gulp = require('gulp');
let nodemon = require('gulp-nodemon');

gulp.task('serve', function() {
    var options = {
        script: 'app.js',
        delayTime: 1,
        env: {
            'PORT': 3000
        }
    };
    
    return nodemon(options)
        .on('restart', function(event) {
            console.log('Restarting...');
        });
});