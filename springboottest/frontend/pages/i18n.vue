<template>

    <v-table
    fixed-header
    height="300px"
  >
    <thead>
      <tr>
        <th class="text-left">
          Name
        </th>
        <th class="text-left">
          Calories
        </th>
      </tr>
    </thead>
    <tbody>
      <tr
        v-for="item in desserts"
        :key="item.name"
      >
        <td>{{ item.name }} {{ $t('sunDay') }}</td>
        <td>{{ item.calories }}</td>
      </tr>
    </tbody>
    <v-btn color="primary" @click="changeLanguage('ko')">KO</v-btn>
    <v-btn color="primary" @click="changeLanguage('en')">EN</v-btn>
  </v-table>
</template>

<script>
export default {
  name: 'i18',
  data () {
    return {
      desserts: [
        {
          name: 'Frozen Yogurt',
          calories: 159
        },
        {
          name: 'Ice cream sandwich',
          calories: 237
        },
        {
          name: 'Eclair',
          calories: 262
        },
        {
          name: 'Cupcake',
          calories: 305
        },
        {
          name: 'Gingerbread',
          calories: 356
        },
        {
          name: 'Jelly bean',
          calories: 375
        }
      ]
    }
  },
  methods: {
    changeLanguage (lang) {
      this.$i18n.setLocale(lang)
    }
  }
}
</script>

