int fractal_newton_tareas(double x1, double x2, double y1, double y2,
                   int w, int h, Byte *A, double tol, int maxiter)
{
    double t = omp_get_wtime();
  int i, j, ni, max;
  Complejo z0;
  double ix, iy;
 
  ix = (x2-x1)/(w-1);
  iy = (y2-y1)/(h-1);
  max = 0;
   
   
  for (i = 0; i < h; i++) {
    #pragma omp task private(j,z0,ni) shared(max)
    {
    z0.b = y1 + iy*i;   
    for (j = 0; j < w; j++) {
      z0.a = x1 + ix*j;
      ni = newton(z0, tol, maxiter);
             
      if (ni > max) {
        #pragma omp critical
        if (ni > max) {max = ni;}
      }      
       
      A(i, j) = ni;
    }
    }
  }
  #pragma omp taskwait
  printf("Ha tardat: %f segons\n",(omp_get_wtime()-t));
  return max;
}

