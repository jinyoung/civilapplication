import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/users',
      component: () => import('../components/ui/UserGrid.vue'),
    },
    {
      path: '/applications',
      component: () => import('../components/ui/ApplicationGrid.vue'),
    },
    {
      path: '/notifications',
      component: () => import('../components/ui/NotificationGrid.vue'),
    },
    {
      path: '/resultDocuments',
      component: () => import('../components/ui/ResultDocumentGrid.vue'),
    },
  ],
})

export default router;
